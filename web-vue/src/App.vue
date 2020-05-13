<template>
  <div id="app">
    <!-- 主界面部分 -->
    <transition name="show">
      <div class="index">
        <!-- 头部 -->
        <VHeader></VHeader>

        <!-- router控制的Tab页内容 -->
        <router-view></router-view>
      </div>
    </transition>
  </div>
</template>

<script>
import VHeader from './components/Header.vue';
import Home from './components/Home.vue';
import MusicList from './components/MusicList.vue';

export default {
  name: 'App',
  components: {
    VHeader,
    MusicList,
    Home
  },
  beforeCreate() {
    this.$store.dispatch('getData');
  },
  methods: {
    toSearch(keywords) {
      if (keywords.trim()) {
        this.axios.get('/api/search/100/' + keywords)
          .then(res => {
            this.$store.commit('setMusicList', res.data.musicList);
          })
      }
    }
  }

}
</script>

<style>
@import "./assets/css/base.css";

</style>
