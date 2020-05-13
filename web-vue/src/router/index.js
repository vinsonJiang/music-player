import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/components/Home'
import Header from '@/components/Header'
import MusicList from '@/components/MusicList'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'MusicList',
      component: MusicList
    },
    {
      path: '/home',
      name: 'Home',
      component: Home
    },
    {
      path: '/header',
      name: 'Header',
      component: Header
    },
    {
      path: '/hello-world',
      name: 'HelloWorld',
      component: HelloWorld
    }
  ]
})
