<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show>
          <h3>회원정보 수정</h3>
        </b-alert>
      </b-col>
    </b-row>
    <user-input-item type="modify" />
  </b-container>
</template>

<script>
import UserInputItem from "@/components/user/UserInputItem";

export default {
  name: "UserInfoModify",
  components: {
    UserInputItem
  }
};
</script>

<style></style>
