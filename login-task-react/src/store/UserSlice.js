import React from "react";
import { createSlice } from "@reduxjs/toolkit";

const UserSlice = createSlice({
  name: "user",
  initialState: {
    user: "",
  },
  reducers: {
    setUser(state, action) {
        console.log(action.payload)
      state.user = action.payload
    },
  },
});

export const { setUser } = UserSlice.actions;
export const userReducer = UserSlice.reducer;
