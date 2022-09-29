import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '@/app/views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    component: () => import('@/app/views/AboutView.vue')
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
