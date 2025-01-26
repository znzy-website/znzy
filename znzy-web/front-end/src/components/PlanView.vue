<script setup>
import {onMounted, reactive, ref} from "vue";
import {get, post} from "@/net/index.js";
import {message} from "ant-design-vue";
const [messageApi,contextHolder] = message.useMessage();

const options=reactive({
  plan:[],
  content:"",
})

const IsShow=ref(false);
const toggleShow=()=>{
  IsShow.value=!IsShow.value;
}
const AddPlan=()=>{
  post("api/plan/addplan",{
    content:options.content,
  },(message,data)=>{
    messageApi.success("添加成功");
    getAllPlan();
  })
}
const getAllPlan=()=>{
  get("api/plan/AllPlan",{},(message,data)=>{
    options.plan=data;
  })
}

onMounted(()=>{
  getAllPlan();
})


</script>

<template>
  <div class="mt-20">
    <!-- 浮动按钮 -->
    <button @click="toggleShow" class="fixed right-10 bg-blue-500 p-3 rounded-full shadow-lg hover:bg-blue-600 transition-all duration-200">
      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" class="size-8 text-white">
        <g fill="none" stroke="currentColor" stroke-width="1.5">
          <path d="m16.652 3.455l.649-.649A2.753 2.753 0 0 1 21.194 6.7l-.65.649m-3.892-3.893s.081 1.379 1.298 2.595c1.216 1.217 2.595 1.298 2.595 1.298m-3.893-3.893L10.687 9.42c-.404.404-.606.606-.78.829q-.308.395-.524.848c-.121.255-.211.526-.392 1.068L8.412 13.9m12.133-6.552l-5.965 5.965c-.404.404-.606.606-.829.78a4.6 4.6 0 0 1-.848.524c-.255.121-.526.211-1.068.392l-1.735.579m0 0l-1.123.374a.742.742 0 0 1-.939-.94l.374-1.122m1.688 1.688L8.412 13.9"/>
          <path stroke-linecap="round" d="M22 12c0 5.523-4.477 10-10 10S2 17.523 2 12S6.477 2 12 2"/>
        </g>
      </svg>
    </button>

    <!-- 输入框 -->
    <div v-if="IsShow" class="fixed mt-20 right-10 bg-white p-4 rounded-xl shadow-lg">
      <div class="w-96 h-fit flex items-center gap-2">
        <input
          type="text"
          v-model="options.content"
          class="w-full h-12 bg-gray-50 font-sans mx-auto px-4 py-2 rounded-lg border-2 border-gray-200 focus:border-blue-500 focus:ring-2 focus:ring-blue-200 transition-all duration-200 ease-in-out placeholder-gray-400 text-gray-700 shadow-sm hover:shadow-md"
          placeholder="请输入你需要制定的计划"
        />
        <button @click="AddPlan"  class="ml-2 p-2 bg-blue-500 rounded-lg hover:bg-blue-600 transition-all duration-200">
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 48 48" class="size-6 text-white">
            <path fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="4" d="m4 24l5-5l10 10L39 9l5 5l-25 25z" clip-rule="evenodd"/>
          </svg>
        </button>
      </div>
    </div>

    <!-- 计划列表 -->
    <div class="flex flex-wrap mx-auto min-h-screen p-4 w-full">
      <div class="max-w-2xl w-full mx-auto">
        <!-- 标题 -->
        <h1 class="text-3xl font-bold mb-6 text-gray-800 text-center">计划列表</h1>

        <!-- 计划列表 -->
        <ul class="space-y-3">
          <li
            v-for="plan in options.plan"
            class="flex items-center p-3 bg-white rounded-lg shadow-sm hover:shadow-md transition-all duration-200"
          >
            <input
              type="checkbox"
              v-model="plan.isfinish"
              class="mr-3 w-5 h-5 text-blue-500 rounded border-gray-300 focus:ring-blue-500"
            />
            <span
              :class="{ 'line-through text-gray-500': plan.isfinish }"
              class="text-lg text-gray-700"
            >
          {{ plan.content }}
              <span>{{options.time}}</span>
        </span>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<style scoped>

</style>
