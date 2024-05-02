import React from "react";
import { Route, Routes } from "react-router-dom";
import { Home } from "../components/Home";
import LoginForm from "../components/LoginForm";
import { Hr } from "../components/Hr";
import { Admin } from "../components/Admin";
import { ExternalEmployee } from "../components/ExternalEmployee";
import { InternalEmployee } from "../components/InternalEmployee";
import Register from "../components/Register";

const AllRoutes = () => {
  return (
    <Routes>
      <Route path="/home" element={<Home />}></Route>
      <Route path="/" element={<LoginForm />}></Route>
      <Route path="/hr" element={<Hr />} />
      <Route path="/admin" element={<Admin />} />
      <Route path="/external" element={<ExternalEmployee />} />
      <Route path="/internal" element={<InternalEmployee />} />
      <Route path="/register" element={<Register />} />
    </Routes>
  );
};

export default AllRoutes;
