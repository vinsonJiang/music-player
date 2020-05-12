<template>
  <div class="hello">
    <div class="container">
      <h1>{{ msg }}</h1>
      <h2>HomePage</h2>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Home',
  data () {
    return {
      msg: 'this is home page'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
