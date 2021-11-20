<template>
  <div>
    <el-menu-item :index="url">
      <span style="text-align:center; width: 100%">
        {{ name }}
      </span>
    </el-menu-item>
  </div>
</template>

<script>
export default {
  name: "side-item",
  props: [
    "name",
    "url"
  ],
  setup() {
    return {}
  }
}
</script>

<style scoped>
</style>