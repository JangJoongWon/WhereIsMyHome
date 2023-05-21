<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show>
          <h3>회원가입</h3>
        </b-alert>
      </b-col>
    </b-row>
    <user-input-item type="register" />
  </b-container>
</template>

<script>
import UserInputItem from "@/components/user/UserInputItem";

export default {
  name: "UserRegister",
  components: {
    UserInputItem
  }
};
</script>

<style></style>
