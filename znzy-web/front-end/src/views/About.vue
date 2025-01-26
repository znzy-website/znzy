<script setup>
// 轮播图配置
import {onMounted, reactive, ref} from "vue";
import {get, post} from "@/net/index.js";
import router from "@/router/index.js";

const images = ref([
  'https://pic4.zhimg.com/v2-a0f50ed0e81fac751dc25ff0003504f6_1440w.jpg?source=172ae18bg',
  'https://ts1.cn.mm.bing.net/th/id/R-C.365eeaf91f016302a86234e28a79e7eb?rik=HtgDUQe9%2fMBK0w&riu=http%3a%2f%2fwww.08lr.cn%2fuploads%2fallimg%2f220414%2f1-235244c63.jpg&ehk=8KBLcuK4bzycWA29c3uvDH5QHc894z9J9OZkRnIS3uQ%3d&risl=&pid=ImgRaw&r=0',
  'https://ts1.cn.mm.bing.net/th/id/R-C.2abe32e72a7f0adf46931a9c3d6ca5aa?rik=w5SIcxSht6D%2f2A&riu=http%3a%2f%2fwww.quazero.com%2fuploads%2fallimg%2f140303%2f1-140303214149.jpg&ehk=FfUA4kpMo7zSp1q700V87tACjT5PdeKdMLnMGs5SC0g%3d&risl=&pid=ImgRaw&r=0',
  'https://pic2.zhimg.com/v2-2b0c25d34d20099035b7ef3bbc07f32f_r.jpg',
]);

const currentIndex = ref(0);

const nextSlide = () => {
  currentIndex.value = (currentIndex.value + 1) % images.value.length;
  restartAutoPlay(); // 每次手动切换后重置自动播放计时器
};

const prevSlide = () => {
  currentIndex.value = (currentIndex.value - 1 + images.value.length) % images.value.length;
  restartAutoPlay(); // 每次手动切换后重置自动播放计时器
};

let autoPlayInterval;

const startAutoPlay = () => {
  autoPlayInterval = setInterval(nextSlide, 3000); // 每3秒切换一次
};

const stopAutoPlay = () => {
  clearInterval(autoPlayInterval);
};

const restartAutoPlay = () => {
  stopAutoPlay(); // 停止当前的自动播放
  startAutoPlay(); // 重新启动自动播放
};

</script>

<template>
  <div class="flex flex-wrap gap-10">
    <div class="mt-32">
      <div class="relative  w-11/12 h-96 overflow-hidden rounded-xl mx-auto shadow-lg">
        <!-- 轮播图容器 -->
        <div class="flex transition-transform duration-500 ease-in-out" :style="{ transform: `translateX(-${currentIndex * 100}%)` }">
          <!-- 轮播图项 -->
          <div v-for="(image, index) in images" :key="index" class="w-full h-full flex-shrink-0">
            <img :src="image" alt="slide" class="w-full h-96 mx-auto items-center justify-center flex object-cover rounded-xl shadow-md">
          </div>
        </div>
        <!-- 上一张按钮 -->
        <button @click="prevSlide" class="absolute top-1/2 left-4 transform -translate-y-1/2 bg-white bg-opacity-70 p-2 rounded-full shadow-lg">
          <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 19l-7-7 7-7" />
          </svg>
        </button>
        <!-- 下一张按钮 -->
        <button @click="nextSlide" class="absolute top-1/2 right-4 transform -translate-y-1/2 bg-white bg-opacity-70 p-2 rounded-full shadow-lg">
          <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7" />
          </svg>
        </button>
      </div>
    </div>
    <div class="flex flex-nowrap mx-auto">
      <button>
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" class="size-12 text-blue-300" @click="router.push('/article')">
          <path fill="currentColor" d="M7.5 16.5h6v-1h-6zm0-4h9v-1h-9zm0-4h9v-1h-9zM5.616 20q-.691 0-1.153-.462T4 18.384V5.616q0-.691.463-1.153T5.616 4h12.769q.69 0 1.153.463T20 5.616v12.769q0 .69-.462 1.153T18.384 20zm0-1h12.769q.23 0 .423-.192t.192-.424V5.616q0-.231-.192-.424T18.384 5H5.616q-.231 0-.424.192T5 5.616v12.769q0 .23.192.423t.423.192M5 5v14z"/>
        </svg>
      </button>
      <button>
        <svg xmlns="http://www.w3.org/2000/svg"  viewBox="0 0 24 24" class="size-12 text-blue-300">
          <g fill="none"><path d="m12.593 23.258l-.011.002l-.071.035l-.02.004l-.014-.004l-.071-.035q-.016-.005-.024.005l-.004.01l-.017.428l.005.02l.01.013l.104.074l.015.004l.012-.004l.104-.074l.012-.016l.004-.017l-.017-.427q-.004-.016-.017-.018m.265-.113l-.013.002l-.185.093l-.01.01l-.003.011l.018.43l.005.012l.008.007l.201.093q.019.005.029-.008l.004-.014l-.034-.614q-.005-.018-.02-.022m-.715.002a.02.02 0 0 0-.027.006l-.006.014l-.034.614q.001.018.017.024l.015-.002l.201-.093l.01-.008l.004-.011l.017-.43l-.003-.012l-.01-.01z"/><path fill="currentColor" d="M16 3a1 1 0 0 1 1 1v1h2a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V7a2 2 0 0 1 2-2h2V4a1 1 0 1 1 2 0v1h6V4a1 1 0 0 1 1-1m3 4H5v12h14zm-4.176 2.379a1 1 0 0 1 1.414 1.414l-4.942 4.943a1.01 1.01 0 0 1-1.429 0L7.753 13.62a1 1 0 0 1 1.414-1.414l1.415 1.414Z"/></g>
        </svg>
      </button>
    </div>
  </div>

</template>



<style scoped>

/* 你可以在这里添加自定义样式 */
</style>
