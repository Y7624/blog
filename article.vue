<template>
  <div class="article">
    <vue-particles />
    <div class="main">
      <h1>日记随笔</h1>
      <div class="article-item">
         <div class="article-content" v-for="item in articleList" :key="item.id"  @click="goToDetail(item.id)">
            <div>{{ item.title }}</div>
            <div>{{ item.content }}</div>
            <div> 
              <img src="/img/time.png">
              {{ item.time }}
            </div>
         </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import vueParticles from "../components/vueParticles.vue";
const router = useRouter();

const articleList = ref([
  {
    id: 1,
    title: '关于React的运行机制',
    content: 'React是一个用于构建用户界面的JavaScript库。它采用组件化的开发模式，使得代码更加模块化和可复用。React的核心思想是虚拟DOM，通过对比虚拟DOM的差异来最小化对真实DOM的操作，从而提高性能。',
    time: '2023-10-27'
  },
  {
    id: 2,
    title: '关于Vue的运行机制',
    content: 'Vue是一套用于构建用户界面的渐进式框架。与其它大型框架不同的是，Vue被设计为可以自底向上逐层应用。Vue的核心库只关注视图层，不仅易于上手，还便于与第三方库或既有项目整合。',
    time: '2023-10-27'
  },
  {
    id: 3,
    title: '关于Spring Boot',
    content: 'Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。',
    time: '2023-10-27'
  }
]);


function addNewArticle() {
  const newArticle = {
    id: Date.now(), 
    title: '一篇新的随笔',
    content: '这是通过函数动态添加的内容。',
    time: new Date().toISOString().split('T')[0] 
  };
  articleList.value.push(newArticle); 
}

function goToDetail(id){
  router.push(`/article/${id}`)
}
</script>


<style scoped>
.article {
   width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
}

.main {
 width: 90%;
  height: 90vh;
  background-color: rgba(240, 240, 240, 0.85);
  display: flex;
  flex-direction: column;
  align-items: center;
  border-radius: 20px;
  border: 1px solid white;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
  padding: 20px;
  box-sizing: border-box;
  overflow-y: auto; 
}

.main h1 {
  margin-top: 20px;
  color: #333;
}

.article-item {
  width: 100%;
  display: flex;
  flex-wrap: wrap; 
  gap: 20px; 
  justify-content: center; 
  margin-top: 10px;
  /* padding: 0 20px; */
}

.article-content {
  flex: 1 1 300px; 
  max-width: 340px; 
  min-height: 200px; 
  background-color: #fff;
  border-radius: 10px;
  border: 1px solid #ccc;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  padding: 20px;
  box-sizing: border-box;
  transition: transform 0.3s ease, box-shadow 0.3s ease; 
}

.article-content:hover {
   transform: scale(1.05); 
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

.article-content div:nth-child(1){
  /* border: 1px solid red; */
  font-size: 26px;
}
.article-content div:nth-child(2){
  /* border: 1px solid red; */
  font-size: 16px;
  margin-top: 20px;
  color: #666;
}
.article-content div:nth-child(3){
  /* border: 1px solid red; */
  font-size: 18px;
  margin-top: 40px;
  
}

.article-content div:nth-child(3) img{
  width: 40px;
  height: 40px;
  margin-right: 5px;
  vertical-align: middle;
}
</style>
