<script setup>
import {message} from "ant-design-vue";
import router from "@/router/index.js";
import {onMounted, reactive} from "vue";
import {get} from "@/net/index.js";
const [contextHolder] = message.useMessage();
//
const options=reactive({
  Articles:[],
})
const getAllArticle=()=>{
  get("api/article/getAllArticle",{},(message,data)=>{
    options.Articles=data;
    // console.log(options.Articles)
  })
}
const gotArticleById=(id)=>{
  router.push("/view/"+id);
}

onMounted(()=>{
  getAllArticle();
})
</script>

<template>
  <contextHolder/>
  <div class="flex flex-wrap">
    <div class="w-3/5  mx-auto mt-24 flex flex-wrap gap-4 overflow-y-auto scrollbar-hide" style="max-height: 600px">
      <div @click="gotArticleById(article.id)" v-for="article in options.Articles" class="cursor-pointer  bg-blue-200 bg-opacity-10 w-full rounded-xl p-2 shadow-sm">
        <div class="grid grid-rows-[2fr,4fr] h-fit">
          <div class=" flex flex-nowrap w-full ">
            <div class="text-2xl text-blue-300 w-1/5 font-kai">{{article.title}}</div>
            <div class="gap-4 flex flex-nowrap">
              <div class="text-xl my-auto h-fit font-kai text-blue-300">{{article.user.name}}</div>
              <img :src="article.user.avatar" alt="头像" class="w-8 rounded-xl object-cover">
              <div class="flex flex-nowrap gap-4">
                <button>
                  <svg xmlns="http://www.w3.org/2000/svg"  viewBox="0 0 24 24" class="size-5 my-auto">
                    <g fill="none" stroke="currentColor" stroke-linecap="round" stroke-width="1.5"><path d="M16.472 20H4.1a.6.6 0 0 1-.6-.6V9.6a.6.6 0 0 1 .6-.6h2.768a2 2 0 0 0 1.715-.971l2.71-4.517a1.631 1.631 0 0 1 2.961 1.308l-1.022 3.408a.6.6 0 0 0 .574.772h4.576a2 2 0 0 1 1.929 2.526l-1.91 7A2 2 0 0 1 16.473 20Z"/><path stroke-linejoin="round" d="M7 20V9"/></g>
                  </svg>
                </button>
                <div class=" my-auto">{{article.likes}}</div>
                <button>
                  <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 36 36" class="size-5 my-auto">
                    <path fill="currentColor" d="M27.19 34a2.2 2.2 0 0 1-1.24-.38l-7.46-5a.22.22 0 0 0-.25 0l-7.46 5a2.22 2.22 0 0 1-3.38-2.41l2.45-8.64a.23.23 0 0 0-.08-.24l-7.06-5.55a2.22 2.22 0 0 1 1.29-4l9-.34a.23.23 0 0 0 .2-.15l3.1-8.43a2.22 2.22 0 0 1 4.17 0l3.1 8.43a.23.23 0 0 0 .2.15l9 .34a2.22 2.22 0 0 1 1.29 4L27 22.33a.22.22 0 0 0-.08.24l2.45 8.64A2.23 2.23 0 0 1 27.19 34m-8.82-7.42a2.2 2.2 0 0 1 1.23.42l7.46 5a.22.22 0 0 0 .34-.25l-2.45-8.64a2.21 2.21 0 0 1 .77-2.35l7.06-5.55a.22.22 0 0 0-.13-.4l-9-.34a2.22 2.22 0 0 1-2-1.46l-3.1-8.43a.22.22 0 0 0-.42 0L15.06 13a2.22 2.22 0 0 1-2 1.46l-9 .34a.22.22 0 0 0-.13.4L11 20.76a2.22 2.22 0 0 1 .77 2.35l-2.44 8.64a.21.21 0 0 0 .08.24a.2.2 0 0 0 .26 0l7.46-5a2.2 2.2 0 0 1 1.23-.37Z" class="clr-i-outline clr-i-outline-path-1"/><path fill="none" d="M0 0h36v36H0z"/>
                  </svg>
                </button>
                <div  class=" my-auto">{{article.favorites}}</div>
                <button>
                  <svg xmlns="http://www.w3.org/2000/svg"  viewBox="0 0 24 24" class="size-5 my-auto">
                    <g fill="currentColor" fill-rule="evenodd" clip-rule="evenodd"><path d="M12 8.25a3.75 3.75 0 1 0 0 7.5a3.75 3.75 0 0 0 0-7.5M9.75 12a2.25 2.25 0 1 1 4.5 0a2.25 2.25 0 0 1-4.5 0"/><path d="M12 3.25c-4.514 0-7.555 2.704-9.32 4.997l-.031.041c-.4.519-.767.996-1.016 1.56c-.267.605-.383 1.264-.383 2.152s.116 1.547.383 2.152c.25.564.617 1.042 1.016 1.56l.032.041C4.445 18.046 7.486 20.75 12 20.75s7.555-2.704 9.32-4.997l.031-.041c.4-.518.767-.996 1.016-1.56c.267-.605.383-1.264.383-2.152s-.116-1.547-.383-2.152c-.25-.564-.617-1.041-1.016-1.56l-.032-.041C19.555 5.954 16.514 3.25 12 3.25M3.87 9.162C5.498 7.045 8.15 4.75 12 4.75s6.501 2.295 8.13 4.412c.44.57.696.91.865 1.292c.158.358.255.795.255 1.546s-.097 1.188-.255 1.546c-.169.382-.426.722-.864 1.292C18.5 16.955 15.85 19.25 12 19.25s-6.501-2.295-8.13-4.412c-.44-.57-.696-.91-.865-1.292c-.158-.358-.255-.795-.255-1.546s.097-1.188.255-1.546c.169-.382.426-.722.864-1.292"/></g>
                  </svg>
                </button>
                <div class=" my-auto">{{article.views}}</div>
              </div>
            </div>
          </div>
          <div class="h-fit font-kai text-green-300 select-none">{{article.content}}</div>
        </div>
      </div>
    </div>
  </div>

</template>

<style scoped>
/*用于隐藏滚动条,::-webkit-scrollbar:这个伪元素用于隐藏 WebKit 浏览器（如 Chrome、Safari）中的滚动条。*/
.scrollbar-hide::-webkit-scrollbar {
  display: none;
}

.scrollbar-hide {
  -ms-overflow-style: none; /*-ms-overflow-style: none;: 这个属性用于隐藏 IE 和 Edge 浏览器中的滚动条。*/
  scrollbar-width: none;  /*scrollbar-width: none;: 这个属性用于隐藏 Firefox 浏览器中的滚动条。*/
}
</style>
