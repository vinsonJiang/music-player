// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios';
import VueAxios from 'vue-axios';
import Vuex from 'vuex'


Vue.config.productionTip = false


// 用 axios 进行 Ajax 请求
Vue.use(VueAxios, axios);

// Vuex 进行状态管理
Vue.use(Vuex);


const store = new Vuex.Store({
  state: {
    musicList: [],
    DOM: {},
    audio: {
      name: '',
      src: '',
      musicImgSrc: '',
      index: 0
    }
  },
  mutations: {
    setMusicList(state, musicList) {
      state.musicList = musicList;
    }
  },

  actions: {
    getData({ commit,state }) {
      // if (localStorage.musics !== '[]' && localStorage.musics) {
      //   state.musicData = JSON.parse(localStorage.musics);
      //   return;
      // }
      return new Promise((resolve, reject) => {
        Vue.axios.get('http://localhost:9001/music-api/search-music?keyword=%E7%9F%A5%E5%90%A6%E7%9F%A5%E5%90%A6')
          .then (res => {
            if (res.data.ret === 0) {
              console.log(res.data.musicList);
              state.musicData = res.data.musicList;
              // localStorage.musics = JSON.stringify(state.musicData);
            }
          })
          .then(() => {
            // commit('toggleMusic',0)
          });
        resolve();
      });
    }
  }
})


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
