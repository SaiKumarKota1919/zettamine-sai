import React from "react";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap/dist/js/bootstrap.bundle.js";
import Logo from "../assets/logo.png";
import "../App.css";
import "../App";
import { useSelector } from "react-redux";
import { Link, NavLink } from "react-router-dom";

export const Header = ({ cartItems }) => {
  let user = useSelector((st) => st.userState.user);
  console.log(user);
  return (
    <nav
      class="navbar navbar-light sticky-top"
      style={{ margin: "10px 0px", backgroundColor: "#b39afd" }}
    >
      <div class="container-fluid">
        <img src={Logo} style={{ width: "80px", height: "50px" }}></img>

        <div class="d-flex">
          <NavLink className="link" to="#">
            <p>HOME</p>
          </NavLink>
          &nbsp; &nbsp;
          <p>{user} Logout</p>
          &nbsp; &nbsp; SIGNUP &nbsp; &nbsp;
          <NavLink className="link" to="#">
            CART  &nbsp;
          </NavLink>
        </div>
      </div>
    </nav>
  );
};
