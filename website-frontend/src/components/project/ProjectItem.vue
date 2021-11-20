<template>
  <el-card body-style="width: 180px; height: 160px">
    <!--the header-->
    <template #header>
      <div class="project-item-title">
        <!-- link -->
        <el-link :href="url">
          <span class="project-item-title-text" >{{ name }}</span>
        </el-link>
      </div>
    </template>
    <!--the desc-->
    <div class="project-item-desc">
      {{desc}}
    </div>

  </el-card>
</template>

<script>
export default {
  name: "ProjectItem",
  props: [
      "url",
      "name",
      "desc"
  ]
}
</script>

<style scoped>
.project-item-title {
}

.project-item-title-text {
  text-align: center;
  font-size: 200%;
}

.project-item-desc {
  font-size: 125%;
  text-align: left;
}
</style>