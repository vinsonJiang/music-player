<template>
  <div class="header">
    <div class="container">
      <div class="nav-bar">
        <ul class="nav">
          <li>
            <a class="btn" data-action="playing" title="当前">当前</a>
          </li>
          <li>
            <a class="btn" data-action="sheet" title="列表">列表</a>
          </li>
        </ul>

        <div class="search-bar">
          <div class="search">
            <input v-model="keyword" type="search" class="search-input" value="" placeholder="搜索">
            <span class="search-icon" v-on:click="toSearch(keyword)"><i class="fa fa-search"></i></span>
            <!--<a class="btn" data-action="search" title="点击搜索">搜索</a>-->
          </div>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
export default {
  name: 'Home',
  data () {
    return {
      msg: 'this is home page',
      searchActive: false
    }
  },
  methods: {
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  @import "https://cdn.bootcdn.net/ajax/libs/animate.css/4.1.0/animate.min.css";
  @import "https://cdn.bootcdn.net/ajax/libs/font-awesome/5.13.0/css/all.min.css";

  ol, ul {
    padding-left: 20px;
    margin-top: 0;
  }

  .nav-bar {
    margin: 0;
    font-size: 18px;
    border-bottom: 1px solid #ddd;
    height: 50px;
  }

  .nav {
    padding-left: 0;
    margin-bottom: 0;
    list-style: none;
    display: inline-block;
    float: left;
  }
  .search-bar {
    float: right;
  }

  .nav>li {
    position: relative;
    display: block;
    float: left;
  }

  .nav>li>a, .search-bar>a {
    position: relative;
    display: block;
    padding: 10px 15px;
    line-height: 30px;
    color: #fff;
    border-radius: 0;
    opacity: .9;
    cursor: pointer;
  }

  .search-bar {
    display: flex;
    align-items: center;
    margin-left: 16px;
    height: 50px;
    width:150px;
    max-width: 100%;
  }
  .search {
    display: inline-flex;
    position: relative;
    margin: 0;
    padding: 0;
    flex-grow: 1;
  }
  .search-input {
    width: 100%;
    height: 36px;
    padding: 8px 36px 8px 16px;
    border-radius: 5px;
    border: none;
  }
  .search-icon {
    position: absolute;
    font-size: 16px;
    top: 25%;
    right: 16px;
    line-height: 0;
    z-index: 2;
    color: #969696;
    font-size: 18px;
  }
</style>
