import { createRouter, createWebHashHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    name: 'home',
    component: () => import('@/app/home/HomeView.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('@/app/auth/LoginComponent.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
