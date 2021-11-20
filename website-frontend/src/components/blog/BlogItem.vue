<template>
  <el-card :body-style="cardStyleSetting">
    <!--the header-->
    <template #header>
      <div class="blog-item-title">
        <!-- router link -->
        <router-link :to="`/blog/${id}`">
          <el-link>
            <span class="blog-item-title-text" >{{ title }}</span>
          </el-link>
        </router-link>
      </div>
    </template>
    <!--the summary-->
    <div class="blog-item-summary">
      {{summary}}
    </div>
    <!--author-->
    <div class="blog-item-author">
      {{ author }}
    </div>
    <!--created date-->
    <div class="blog-item-created-date">
      {{createdDate}}
    </div>
  </el-card>
</template>

<script>
import {ref, onMounted} from "vue";

export default {
  name: "blog-item",
  props: [
    "id",
    "title",
    "author",
    "summary",
    "createdDate",
    "type",
    "blogContainer"
  ],
  setup(props) {
    const cardStyleSetting = ref({
      width: '100px',
    })

    onMounted(() => {
      cardStyleSetting.value.width = `${props.blogContainer.value.clientWidth * .80}px`
    })

    return {cardStyleSetting}
  }
}
</script>

<style>

.blog-item-title {
  display: flex;
}

.blog-item-title-text {
  font-size: 150%;
}

.blog-item-summary {
  text-align: left;
  word-wrap: break-word;
}

.blog-item-author {
  text-align: right;
  margin-bottom: 1%;
}

.blog-item-created-date {
  text-align: right;
}

</style>