<template>
  <transition name="showRouter">
    <div class="music-list">

      <div v-for="(item, index) of musicData" class="music-item">
        <img class="music-img"></img>
        <span class="music-name">{{ (index+1) + '.&nbsp; ' + '歌名'}}</span>
        <span class="del-icon"></span>
      </div>

      <!--<div class="tips">没有更多歌曲了～</div>-->

    </div>
  </transition>
</template>

<script>
export default {
  name: 'Home',
  data () {
    return {
      msg: 'this is home page'
    }
  },
  computed: {
    musicData() {
      return [{name:'first', song:'two'}];
    },
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .music-item {
    width: 100%;
    height: 50px;
    line-height: 50px;
    color: #bdbdbe;
    color: rgba(225,225,225,.8);
    font-size: 14px;
    overflow: hidden;
    border-bottom: 1px solid rgba(150,150,150,.1);
    cursor: default;
    position: relative;
  }

</style>
