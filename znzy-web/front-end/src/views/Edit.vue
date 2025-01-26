<script setup>
import {reactive} from 'vue';
import { MdEditor } from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import {post} from "@/net/index.js";
import {message} from "ant-design-vue";
const [messageApi, contextHolder] = message.useMessage();

// const text = ref('# Hello Editor');
const options=reactive({
  title:"",
  content:"",
})

const addArticle=()=>{
  post("api/article/addArticle",{
    id:1,
    title:options.title,
    content:options.content,
  },(message)=>{
    messageApi.success(message);
  })
}
</script>

<template>
  <contextHolder/>
  <div class="mt-24 w-full flex flex-nowrap">
    <div class="mx-auto items-center justify-center w-4/5 gap-10">
      <div class="flex flex-nowrap gap-4">
        <input
          type="text"
          id="inputField"
          v-model="options.title"
          class="mt-5 mb-5 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
          placeholder="请输入内容"
        />
        <button @click="addArticle">
          <svg xmlns="http://www.w3.org/2000/svg"  viewBox="0 0 24 24" class="size-8 text-black hover:text-blue-600">
            <path fill="none" stroke="currentColor" stroke-width="2" d="m17 12l-5-5l-5 5m5-4v10m0 5c6.075 0 11-4.925 11-11S18.075 1 12 1S1 5.925 1 12s4.925 11 11 11z"/>
          </svg>
        </button>
      </div>
      <MdEditor v-model="options.content" class=""/>
    </div>
  </div>

</template>


