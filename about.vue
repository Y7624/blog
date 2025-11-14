<template>
  <div class="about">
    <vue-particles />
    <div class="main">
      <h1>个人档案</h1>
      <div class="intro">
        <div class="avatar">
          <p>Y</p>
          <p>18岁，200,天秤座，现实的疯子,爱好是听歌，类型不具体。</p>
        </div>
      </div>

      <div class="technology">
        <p>技术栈</p>
        <div>
          <div class="technology-item">
            <div>
              <p>springboot</p>
              <img src="/img/spring_boot_logo.png" alt="" />
            </div>
            <div>
              <p>vue.js</p>
              <img src="/img/vue_logo.jpg" alt="" />
            </div>
            <div>
              <p>java</p>
              <img src="/img/java_logo.webp" alt="" />
            </div>
            <div>
              <p>mysql</p>
              <img src="/img/mysql_logo.webp" alt="" />
            </div>
          </div>
        </div>
      </div>

      <div class="contact">
        <p>联系方式</p>
        <div class="contact-items">
          <div class="contact-item-wrapper">
            <p>qq</p>
            <img @click="showQQ = true" src="/public/img/QQ.png" alt="QQ" />

            <div v-if="showQQ" class="modal-overlay" @click="showQQ = false">
              <div class="modal-content" @click.stop>
                <button class="close-btn" @click="showQQ = false">
                  &times;
                </button>
                <div class="qr-code-container">
                  <img src="/public/img/a5.jpg" class="qr-code-image" />
                  <p class="qr-code-tip">扫码添加QQ</p>
                </div>
              </div>
            </div>
          </div>

          <div class="contact-item-wrapper">
            <p>微信</p>
            <img
              @click="showWechat = true"
              src="/public/img/wechat.png"
              alt="Wechat"
            />
            <div
              v-if="showWechat"
              class="modal-overlay"
              @click="showWechat = false"
            >
              <div class="modal-content" @click.stop>
                <button class="close-btn" @click="showWechat = false">
                  &times;
                </button>
                <div class="qr-code-container">
                  <img
                    src="/public/img/a6.jpg"
                    alt="微信二维码"
                    class="qr-code-image"
                  />
                  <p class="qr-code-tip">扫码添加微信</p>
                </div>
              </div>
            </div>
          </div>

          <div class="contact-item-wrapper">
            <p>github</p>
            <a
              href="https://github.com/Y7624/skills-github-page"
              target="_blank"
            >
              <svg viewBox="0 0 24 24" fill="black" width="40" height="40">
                <path
                  d="M12 0c-6.626 0-12 5.373-12 12 0 5.302 3.438 9.8 8.207 11.387.599.111.793-.261.793-.577v-2.234c-3.338.726-4.033-1.416-4.033-1.416-.546-1.387-1.333-1.756-1.333-1.756-1.089-.745.083-.729.083-.729 1.205.084 1.839 1.237 1.839 1.237 1.07 1.834 2.807 1.304 3.492.997.107-.775.418-1.305.762-1.604-2.665-.305-5.467-1.334-5.467-5.931 0-1.311.469-2.381 1.236-3.221-.124-.303-.535-1.524.117-3.176 0 0 1.008-.322 3.301 1.23.957-.266 1.983-.399 3.003-.404 1.02.005 2.047.138 3.006.404 2.291-1.552 3.297-1.23 3.297-1.23.653 1.653.242 2.874.118 3.176.77.84 1.235 1.911 1.235 3.221 0 4.609-2.807 5.624-5.479 5.921.43.372.823 1.102.823 2.222v3.293c0 .319.192.694.801.576 4.765-1.589 8.202-6.086 8.202-11.386 0-6.627-5.373-12-12-12z"
                />
              </svg>
            </a>
          </div>

          <div class="contact-item-wrapper">
            <p>gitee</p>
            <a href="https://gitee.com/susu7923" target="_blank">
              <svg
                class="icon"
                aria-hidden="true"
                viewBox="0 0 1024 1024"
                width="40"
                height="40"
              >
                <path
                  d="M512 42.666667A464.64 464.64 0 0 1 976.533333 507.733333a4.266667 4.266667 0 0 1-4.266666 4.266667H584.533333a4.266667 4.266667 0 0 1-4.266666-4.266667V418.133333a4.266667 4.266667 0 0 1 4.266666-4.266666h238.933334A416.853333 416.853333 0 0 0 512 85.333333a416.853333 416.853333 0 0 0-311.466667 328.533334h238.933334a4.266667 4.266667 0 0 1 4.266666 4.266666v89.6a4.266667 4.266667 0 0 1-4.266666 4.266667H47.733333a4.266667 4.266667 0 0 1-4.266666-4.266667A464.64 464.64 0 0 1 512 42.666667z"
                  fill="#000000"
                />
                <path
                  d="M531.2 533.333333h238.933333a4.266667 4.266667 0 0 1 4.266667 4.266667v437.333333a4.266667 4.266667 0 0 1-4.266667 4.266667H531.2a4.266667 4.266667 0 0 1-4.266667-4.266667V537.6a4.266667 4.266667 0 0 1 4.266667-4.266667z"
                  fill="#000000"
                />
              </svg>
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import vueParticles from "../components/vueParticles.vue";

import { ref } from "vue";
const showQQ = ref(false);
const showWechat = ref(false);
</script>

<style scoped>
.about {
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
}

.about vue-particles {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: -1;
}

.main {
  width: 80%;
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
}

.main h1 {
  margin-top: 20px;
  color: #333;
}

.intro {
  height: 200px;
  width: 90%;
  background-color: rgba(255, 255, 255, 0.5);
  border: 1px dashed #ccc;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 12px;
  margin-top: 20px;
  flex-direction: column;
}

.intro:hover {
  background: #ffffff;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}
.intro .avatar {
  display: flex;
  align-items: center;
  /* gap: 20px;  */
  flex-direction: column;
}

.intro .avatar p:first-child {
  width: 40px;
  height: 40px;

  color: black;
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 32px;
  font-weight: bold;
}

.intro .avatar p:last-child {
  font-size: 16px;
  color: #555;
}

.technology {
  width: 90%;
  height: 180px;
  background-color: rgba(255, 255, 255, 0.5);
  border-radius: 12px;
  margin-top: 20px;
  border: 1px dashed #ccc;
  display: flex;
}
.technology:hover {
  background: #ffffff;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.technology > p {
  font-size: 24px;
  font-weight: bold;
  margin-left: 10px;
}

.technology-item{
  display: flex;
  flex-direction: row;
}
.technology-item > div {
  /* border: 1px solid red; */
  display: flex;
  flex-direction: column;
  margin-left: 60px;
}

.technology-item > div > p {
  display: flex;
  /* text-align: center;
  border: 1px solid red; */
  justify-content: center;
}
.technology-item > div:hover {
  transform: scale(1.1);
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
}

.technology-item > div img {
  width: 80px;
  height: 80px;
  justify-content: center;

}
.contact {
  width: 90%;
  height: auto;
  min-height: 160px;
  background-color: rgba(255, 255, 255, 0.5);
  border-radius: 12px;
  margin-top: 20px;
  border: 1px dashed #ccc;
  box-sizing: border-box;
}

.contact:hover {
  background: #ffffff;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.contact > p {
  font-size: 24px;
  font-weight: bold;
  margin-top: 20px;
  margin-left: 10px;
}
.contact-items {
  display: flex;
  /* justify-content: center; */
  gap: 40px;
  flex-wrap: wrap;
  margin-bottom: 20px;
  margin-left: 200px;
  /* border: 1px solid red; */
}

.contact-item-wrapper {
  display: flex;
  flex-direction: column;
  /* border: 1px solid red; */
  transition: transform 0.3s ease;
  /* margin-top: 0px; */
}

.contact-item-wrapper:hover {
  transform: translateY(-5px);
}

.contact-item-wrapper > p {
  font-size: 16px;
  color: #555;
  margin: 0;
  font-weight: 500;
  margin-bottom: 4px;
}

.contact-item-wrapper > icon {
  margin-top: 10px;
}

.contact-item-wrapper > img,
.contact-item-wrapper > svg {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  cursor: pointer;
  transition: all 0.3s ease;
  /* background-color: white; */
  padding: 8px;
  /* box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1); */
}

.contact-item-wrapper > img:hover,
.contact-item-wrapper > svg:hover {
  transform: scale(1.1);
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
}

.modal-overlay {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 380px;
  height: 420px;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 12px;
  z-index: 1000;
  backdrop-filter: blur(5px);
}

.modal-content {
  width: 100%;
  height: 100%;
  background: white;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  border-radius: 8px;
  position: relative;
  padding: 20px;
}

.close-btn {
  position: absolute;
  top: 10px;
  right: 10px;
  width: 30px;
  height: 30px;
  border: none;
  background: #f0f0f0;
  border-radius: 50%;
  cursor: pointer;
  font-size: 18px;
  display: flex;
  align-items: center;
  justify-content: center;
  transition: all 0.3s ease;
}

.close-btn:hover {
  background: #e0e0e0;
  transform: rotate(90deg);
}

.qr-code-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 15px;
}

.qr-code-image {
  width: 300px;
  height: 360px;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.qr-code-tip {
  font-size: 16px;
  color: #333;
  margin: 0;
  font-weight: 500;
}
</style>
