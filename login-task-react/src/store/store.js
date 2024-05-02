import React from "react";
import { configureStore } from "@reduxjs/toolkit";
import { userReducer } from "./UserSlice";

const store = configureStore({
  reducer: {
    userState: userReducer,
  },
});

export default store;
