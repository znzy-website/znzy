import { createRouter, createWebHistory } from 'vue-router'
import {userUserStore} from "@/stores/userStore.js";
import {get} from "@/net/index.js";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/auth',
      name: 'login',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('@/components/LoginFrom.vue'),
    },
    {
      path: '/',
      name: '界面',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('@/views/HomeScreen.vue'),
      children:[
        {
          path: '/',
          name: '主界面',
          component: () => import('@/views/About.vue'),
        },
        {
          path: '/edit',
          name: '发布界面',
          // route level code-splitting
          // this generates a separate chunk (About.[hash].js) for this route
          // which is lazy-loaded when the route is visited.
          component: () => import('@/views/Edit.vue'),
        },{
          path: '/view/:id',
          name: '浏览界面',
          // route level code-splitting
          // this generates a separate chunk (About.[hash].js) for this route
          // which is lazy-loaded when the route is visited.
          component: () => import('@/views/ViewArticle.vue'),
        },
        {
          path: '/article',
          name: '文章界面',
          // route level code-splitting
          // this generates a separate chunk (About.[hash].js) for this route
          // which is lazy-loaded when the route is visited.
          component: () => import('@/views/Article.vue'),
        },
        {
          path:'/plan',
          name: '日程界面',
          // route level code-splitting
          // this generates a separate chunk (About.[hash].js) for this route
          // which is lazy-loaded when the route is visited.
          component: () => import('@/components/PlanView.vue'),
        }
      ]
    },
  ],
})

router.beforeEach((to, from, next)=>
{
  const userStore = userUserStore()
  const publicMap = new Map()
  publicMap.set('/auth', 2)
  publicMap.set('/test', 3)
  publicMap.set('/error/401', 4)
  publicMap.set('/error/404', 5)
  if (to.matched.length === 0) next('error/404')

  if (!publicMap.has(to.path)) {
    // 不是访问根路径，检查用户状态
    const user = userStore.user; // 假设你的用户状态保存在Vuex的`user`状态中
    if (user === null) {
      get('api/user/information', {},
        (message, data) => {
          userStore.login(data);
          next();
        }, (message, data) => {
          next('/auth')
        }, (message, data) => {
          next('/auth')
        }
      )
    } else {
      // 用户已登录，允许路由继续
      next();
    }
  } else {
    // 访问的是根路径或其他公开路径，直接放行
    next();
  }
})

export default router
