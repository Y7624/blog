<template>
  <div class="article-detail">
    <vue-particles />
    <div class="main">
      <div class="back-button" @click="goBack">
        ← 返回
      </div>
      <div class="article-content" v-if="currentArticle">
        <h1>{{ currentArticle.title }}</h1>
        <div class="article-meta">
          <img src="/img/time.png">
          <span>{{ currentArticle.time }}</span>
        </div>
        <div class="article-body">
          {{ currentArticle.content }}
        </div>
      </div>

      <!-- 评论区域 -->
      <div class="comments-section">
        <h2>评论 ({{ comments.length }})</h2>
        
        <!-- 添加评论表单 -->
        <div class="add-comment">
          <h3>添加评论</h3>
          <div class="comment-form">
            <input 
              v-model="newComment.name" 
              placeholder="您的昵称" 
              class="name-input"
            />
            <textarea 
              v-model="newComment.content" 
              placeholder="写下您的评论..." 
              class="content-textarea"
            ></textarea>
            <button @click="addComment" class="submit-button">提交评论</button>
          </div>
        </div>

        <!-- 评论列表 -->
        <div class="comments-list">
          <div 
            v-for="comment in comments" 
            :key="comment.id" 
            class="comment-item"
          >
            <div class="comment-header">
              <span class="comment-author">{{ comment.name }}</span>
              <span class="comment-date">{{ comment.createdAt ? formatDate(comment.createdAt) : formatDate(comment.id) }}</span>
            </div>
            <div class="comment-content">
              {{ comment.content }}
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import vueParticles from "../components/vueParticles.vue";

// 模拟API调用
const API_BASE_URL = '/api/blog';

// 模拟获取评论数据
async function fetchCommentsFromAPI(articleId) {
  try {
    // 在实际应用中，这里应该是：
    // const response = await fetch(`${API_BASE_URL}/comments/article/${articleId}`);
    // const comments = await response.json();
    // return comments;
    
    // 模拟数据
    return [
      {
        id: 1,
        articleId: articleId,
        name: '张三',
        content: '这篇文章写得真好，学到了很多知识！',
        createdAt: new Date(Date.now() - 24 * 60 * 60 * 1000).toISOString() // 24小时前
      },
      {
        id: 2,
        articleId: articleId,
        name: '李四',
        content: '感谢分享，对我很有帮助。',
        createdAt: new Date(Date.now() - 2 * 60 * 60 * 1000).toISOString() // 2小时前
      }
    ];
  } catch (error) {
    console.error('获取评论失败:', error);
    return [];
  }
}

// 模拟保存评论到后端
async function saveCommentToAPI(comment) {
  try {
    // 在实际应用中，这里应该是：
    // const response = await fetch(`${API_BASE_URL}/comments`, {
    //   method: 'POST',
    //   headers: {
    //     'Content-Type': 'application/json',
    //   },
    //   body: JSON.stringify(comment),
    // });
    // const savedComment = await response.json();
    // return savedComment;
    
    // 模拟保存成功
    console.log('保存评论到后端:', comment);
    return { ...comment, id: Date.now(), createdAt: new Date().toISOString() };
  } catch (error) {
    console.error('保存评论失败:', error);
    throw error;
  }
}

const route = useRoute();
const router = useRouter();

// 文章数据
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

const currentArticle = ref(null);
const comments = ref([]);
const newComment = ref({
  name: '',
  content: ''
});

// 获取文章详情
onMounted(() => {
  const articleId = parseInt(route.params.id);
  currentArticle.value = articleList.value.find(article => article.id === articleId) || null;
  
  // 模拟从后端获取评论数据
  fetchComments(articleId);
});

// 获取评论数据
async function fetchComments(articleId) {
  comments.value = await fetchCommentsFromAPI(articleId);
}

// 添加评论
async function addComment() {
  if (!newComment.value.name.trim() || !newComment.value.content.trim()) {
    alert('请填写昵称和评论内容');
    return;
  }

  const comment = {
    articleId: currentArticle.value.id,
    name: newComment.value.name,
    content: newComment.value.content
  };

  try {
    const savedComment = await saveCommentToAPI(comment);
    comments.value.push(savedComment);
    
    // 清空表单
    newComment.value.name = '';
    newComment.value.content = '';
  } catch (error) {
    alert('评论保存失败，请重试');
  }
}



// 格式化日期
function formatDate(timestamp) {
  // 如果是ISO字符串格式
  if (typeof timestamp === 'string') {
    const date = new Date(timestamp);
    return `${date.getFullYear()}-${(date.getMonth() + 1).toString().padStart(2, '0')}-${date.getDate().toString().padStart(2, '0')} ${date.getHours().toString().padStart(2, '0')}:${date.getMinutes().toString().padStart(2, '0')}`;
  }
  
  // 如果是时间戳
  const date = new Date(timestamp);
  return `${date.getFullYear()}-${(date.getMonth() + 1).toString().padStart(2, '0')}-${date.getDate().toString().padStart(2, '0')} ${date.getHours().toString().padStart(2, '0')}:${date.getMinutes().toString().padStart(2, '0')}`;
}

// 返回上一页
function goBack() {
  router.go(-1);
}
</script>

<style scoped>
.article-detail {
  width: 100%;
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
}

.main {
  width: 90%;
  max-width: 800px;
  min-height: 90vh;
  background-color: rgba(240, 240, 240, 0.85);
  display: flex;
  flex-direction: column;
  align-items: center;
  border-radius: 20px;
  border: 1px solid white;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
  padding: 20px;
  box-sizing: border-box;
  margin: 20px 0;
}

.back-button {
  align-self: flex-start;
  margin-bottom: 20px;
  cursor: pointer;
  font-size: 18px;
  color: #333;
  padding: 5px 10px;
  border-radius: 5px;
  transition: background-color 0.3s;
}

.back-button:hover {
  background-color: rgba(0, 0, 0, 0.1);
}

.article-content {
  width: 100%;
  background-color: #fff;
  border-radius: 10px;
  padding: 20px;
  box-sizing: border-box;
  margin-bottom: 30px;
}

.article-content h1 {
  color: #333;
  margin-bottom: 10px;
}

.article-meta {
  display: flex;
  align-items: center;
  color: #666;
  margin-bottom: 20px;
}

.article-meta img {
  width: 20px;
  height: 20px;
  margin-right: 5px;
}

.article-body {
  font-size: 16px;
  line-height: 1.6;
  color: #444;
}

.comments-section {
  width: 100%;
  background-color: #fff;
  border-radius: 10px;
  padding: 20px;
  box-sizing: border-box;
}

.comments-section h2 {
  color: #333;
  margin-bottom: 20px;
}

.add-comment h3 {
  color: #333;
  margin-bottom: 15px;
}

.comment-form {
  display: flex;
  flex-direction: column;
  gap: 15px;
  margin-bottom: 30px;
}

.name-input,
.content-textarea {
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 5px;
  font-size: 14px;
  font-family: inherit;
}

.name-input {
  max-width: 300px;
}

.content-textarea {
  min-height: 100px;
  resize: vertical;
}

.submit-button {
  align-self: flex-start;
  padding: 10px 20px;
  background-color: #42b983;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 14px;
  transition: background-color 0.3s;
}

.submit-button:hover {
  background-color: #359c6d;
}

.comments-list {
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.comment-item {
  border-bottom: 1px solid #eee;
  padding-bottom: 15px;
}

.comment-item:last-child {
  border-bottom: none;
}

.comment-header {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
}

.comment-author {
  font-weight: bold;
  color: #333;
}

.comment-date {
  color: #999;
  font-size: 12px;
}

.comment-content {
  color: #555;
  line-height: 1.5;
}
</style>