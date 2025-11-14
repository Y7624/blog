<template>
  <div class="home">
    <vue-particles/>
    <div class="header">
      <div>
        <div>susu的blog</div>
        <div>满怀希望就会所向披靡</div>
      </div>
      <div class="music">
        <img @click="toggleMusic" :class="{ 'playing': isPlaying }"  src="/img/music.png" >
        <audio ref="audioPlayer" @ended="onMusicEnded"></audio>
      </div>
    </div>
    <div class="content">
      <div>
        <div class="title">日记随笔</div>
        <img @click="Article" src="/img/photo.png" alt="" />
      </div>
      <div>
        <div class="title">项目归纳</div>
        <img @click="projects" src="/img/note.png" alt="" />
      </div>
      <div>
        <div class="title">关于我</div>
        <img @click="About" src="/img/flowers.png" alt="" />
      </div>
    </div>
    <div class="everyday">
      <div class="image-container">
        <div class="image-wrap">
          <div v-for="(img, index) in imageList" :key="index">
            <img :src="img.url" class="img" />
          </div>
        </div>
      </div>
      <div class="data">
        <div
          style="
            font-size: 30px;
            margin-top: 20px;
            color: #2a3b4c;
            margin-top: 50px;
          "
        >
          数据墙
        </div>
        <div class="data-group" v-for="(item, index) in statsList" :key="index">
          <div class="data-item">
            <span>浏览量</span>
            <span>{{ item.views }}</span>
          </div>
          <div class="data-item">
            <span>文章数</span>
            <span>{{ item.articles }}</span>
          </div>
          <div class="data-item">
            <span>项目数</span>
            <span>{{ item.projects }}</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import About from "./about.vue";
import Article from "./article.vue";
import vueParticles from "../components/vueParticles.vue";

export default {
  components: {
    vueParticles
  },
  data() {
    return {
      isPlaying: false,
      audioSrc: "/Lonely Day.mp3",
      name: "home",
      imageList: [
        { url: "/img/a1.jpg" },
        { url: "/img/a2.jpg" },
        { url: "/img/a3.jpg" },
      ],
      statsList: [{ views: 1, articles: 2, projects: 3 }],
    };
  },
  mounted() {
    this.$refs.audioPlayer.src=this.audioSrc;
    this.$refs.audioPlayer.addEventListener('error',this.onAudioError);
  },
  beforeDestroy(){
    if(this.$refs.audioPlayer){
      this.$refs.audioPlayer.removeEventListener('error',this.onAudioError);
    }
  },
  methods: {
  toggleMusic() {
    const audio = this.$refs.audioPlayer;

    if (this.isPlaying) {
      audio.pause();
    } else {
      const playPromise = audio.play();
      if (playPromise !== undefined) {
        playPromise.catch(error => {
          console.error("播放音频失败:", error);
        });
      }
    }
    this.isPlaying = !this.isPlaying;
  }, 

  onMusicEnded() {
    this.isPlaying = false;
  }, 

  onAudioError(e) {
    console.error("音频文件加载失败,请检查路径:", this.audioSrc);
  }, 

  particlesLoaded(container) {
    console.log("Particles loaded:", container);
  }, 

  Article() {
    this.$router.push("/article");
  }, 

  projects() {
    this.$router.push("/project");
  }, 

  About() {
    this.$router.push("/about");
  } 
}
  }
</script>

<style scoped>
.home {
  width: 100%;
  height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  z-index: 1;
}

.header {
  width: 67%;
  height: 200px;
  background-color: #f0f0f0;
  display: flex;
  flex-direction: row;
  margin-top: 30px;
  border-radius: 20px;
  border: 1px solid white;
  opacity: 0.7;
}

.header div {
  display: flex;
  flex-direction: column;
  margin-top: 10px;
  margin-bottom: 10px;
}

.header div:nth-child(1) {
  font-size: 40px;
  display: flex;
  margin-left: 36px;
  color: #2a3b4c;
}

.music img {
  width: 100px;
  height: 100px;
  margin-left: 20px;
  transition: transform 0.3s ease;
  cursor: pointer; 
  margin-top: 10px;
  display: flex;
}

@keyframes spin {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}

.music img.playing {
  animation: spin 4s linear infinite;
}

.header div:nth-child(2) {
  font-size: 28px;
  margin-left: 36px;
  margin-top: 20px;
  color: #9d8441;
}
.content {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  gap: 40px;
  height: auto;
  width: 1400px;
  margin-top: 100px;
  margin-bottom: 60px;
}

.content > div {
  background-color: #f0f0f0;
  width: 500px;
  height: 200px;
  border-radius: 10px;
  opacity: 0.7;
  /* border: 1px solid red; */
  display: flex;
  flex-direction: column;
  /* justify-content: center;
  align-items: center; */
  transition: all 0.3s ease;
}

.content > div:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
}

.title {
  font-size: 30px;
  font-weight: 600;
  color: #2a3b4c;
  margin-bottom: 20px;
  margin-left: 30px;
  margin-top: 30px;
}

.content img {
  width: 100px;
  height: 100px;
  object-fit: cover;
  border-radius: 8px;
  margin: 0;
  margin-left: 320px;
  margin-top: 10px;
}

.everyday {
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 20px;
  margin-bottom: 60px;
  margin-top: 60px;
  opacity: 0.7;
}

.image-container {
  background-color: #f0f0f0;
  width: 1000px;
  height: 260px;
  margin-right: 50px;
  border-radius: 10px;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 10px 0;
}

.image-wrap {
  display: flex;
  gap: 80px;
  width: 100%;
  justify-content: center;
}

.img {
  width: 200px;
  height: 200px;
  object-fit: cover;
  border-radius: 10px;
  display: block;
  margin: 0;
  box-shadow: 0px 1px 1px 1px rgba(0, 0, 0, 0.3);
}

.img:hover {
  transform: translateY(-3px);
  box-shadow: 0px 1px 2px 2px rgba(0, 0, 0, 0.3);
}

.data {
  width: 310px;
  height: 286px;
  margin-left: 50px;
  display: flex;
  border-radius: 10px;
  /* border: 1px solid red; */
  background-color: #f0f0f0;
  /* justify-content: center; */
  /* align-content: center; */
  text-align: center;
  flex-direction: column;
}

.data-group {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  margin-top: 20px;
}

.data-item {
  display: flex;
  flex-direction: column;
  align-items: center;
  font-size: 24px;
}
</style>
