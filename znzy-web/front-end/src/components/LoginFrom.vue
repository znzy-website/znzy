<script setup>

import {reactive} from "vue";
import {post} from "@/net/index.js";
import {message} from "ant-design-vue";
import router from "@/router/index.js";
const [messageApi, contextHolder] = message.useMessage();

const options =reactive({
  name:"",
  password:"",
})

const Login=()=>{
  post("/api/auth/login", {
    username:options.name,
    password: options.password,
    },(message,data)=>{
    messageApi.success(message+"一秒后跳转到主界面！");
    localStorage.setItem("authToken",data);
    setTimeout(()=>{
      router.push('/');
    },1000);
  })
}


</script>

<template>
  <contextHolder/>
  <div class="min-h-screen flex items-center justify-center bg-gray-100">
    <div class="bg-white p-8 rounded-lg shadow-md w-full max-w-md">
      <h2 class="text-2xl font-bold mb-6 text-center">Login</h2>
        <div class="mb-4">
          <label for="email" class="block text-sm font-medium text-gray-700">Email</label>
          <input
            type="email"
            id="email"
            v-model="options.name"
            class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
            required
          />
        </div>
        <div class="mb-6">
          <label for="password" class="block text-sm font-medium text-gray-700">Password</label>
          <input
            type="password"
            id="password"
            v-model="options.password"
            class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
            required
          />
        </div>
        <button
          @click="Login"
          type="submit"
          class="w-full bg-indigo-600 text-white py-2 px-4 rounded-md hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2"
        >
          Login
        </button>
    </div>
  </div>
</template>


<style scoped>
/* 你可以在这里添加自定义样式 */
</style>
