<template>
  <nav class="fixed top-0 left-0 w-full shadow-md z-50 shadow-gray-200 bg-white">
    <div class="container mx-auto flex items-center justify-between py-4 px-6 ">
      <!-- 左侧 Logo -->
      <div class="flex items-center">
        <button @click="router().push('/')">
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" class="size-8 text-black hover:text-blue-300 select-none cursor-pointer">
            <path fill="currentColor" d="M6 19h3v-5q0-.425.288-.712T10 13h4q.425 0 .713.288T15 14v5h3v-9l-6-4.5L6 10zm-2 0v-9q0-.475.213-.9t.587-.7l6-4.5q.525-.4 1.2-.4t1.2.4l6 4.5q.375.275.588.7T20 10v9q0 .825-.588 1.413T18 21h-4q-.425 0-.712-.288T13 20v-5h-2v5q0 .425-.288.713T10 21H6q-.825 0-1.412-.587T4 19m8-6.75"/>
          </svg>
        </button>
<!--        <img src="../assets/logo-left.png" alt="Left Logo" class="h-8">-->
      </div>

      <!-- 右侧 Logo -->
      <div class="flex items-center gap-4">
        <div @click="router().push('/edit')">
          <svg  xmlns="http://www.w3.org/2000/svg"  viewBox="0 0 24 24" class="size-6 text-black hover:text-blue-300 select-none cursor-pointer mr-5">
            <path fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 20h4L18.5 9.5a2.828 2.828 0 1 0-4-4L4 16zm9.5-13.5l4 4M17 17v5m4-5v5"/>
          </svg>
        </div>
        <img  src="https://www.matiji.net/img/2024-05-22/KkXdNM4WffX18NP75ZhiEf88HDx7zSbZ.jpg?x-oss-process=image/resize,h_120,w_120" alt="Right Logo" class="h-8 rounded-xl">
        <svg xmlns="http://www.w3.org/2000/svg"  viewBox="0 0 24 24" class="size-6 text-black hover:text-blue-300 select-none cursor-pointer">
          <path fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 4.001H5v14a2 2 0 0 0 2 2h8m1-5l3-3m0 0l-3-3m3 3H9"/>
        </svg>
      </div>
    </div>
  </nav>
  <main >
    <RouterView/>
  </main>
</template>

<script>


import router from "@/router/index.js";
import {defineComponent} from "vue";

export default defineComponent({
  methods: {
    router() {
      return router
    }
  }
})

</script>

<style scoped>
/* 你可以在这里添加自定义样式 */
</style>
