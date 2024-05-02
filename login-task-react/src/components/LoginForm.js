import React, { useEffect, useState } from "react";
import { useRef } from "react";

import "bootstrap/dist/css/bootstrap.css";
import "bootstrap/dist/js/bootstrap.bundle.js";
import { UserService } from "../services/UserService";
import { NavLink, useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";

import { setUser } from "../store/UserSlice";

const LoginForm = () => {
  let emailRef = useRef("");
  let passwordRef = useRef("");
  let navigate = useNavigate();
  let dispatch = useDispatch();

  let email = emailRef.current.value;
  const emailRegex =
    /^[a-zA-Z0-9!_.-]+@(?:gmail|yahoo|zettamine)\.(?:com|net|in)$/;
  let [validEmail, setValidEmail] = useState(false);

  useEffect(() => {
    document.getElementById("password").focus();
  }, [validEmail]);

  function handleSubmit() {
    UserService.userLogin(email, passwordRef.current.value)
      .then((res) => {
        dispatch(setUser(res.data.email));

        switch (res.data.roleId) {
          case 1:
            navigate("/admin");
            break;
          case 2:
            navigate("/hr");
            break;
          case 3:
            navigate("/internal");
            break;
          case 4:
            navigate("/external");
            break;
        }
      })
      .catch((err) => {
        if (err.response.status == 401) {
          let remainigAttempts = 5 - err.response.data.attempts;
          if (remainigAttempts != 0) {
            document.getElementById("attempts").innerHTML =
              "Invalid credentials remainig attempts " + remainigAttempts;
          } else {
            document.getElementById("attempts").innerHTML =
              "Account is Locked please contact admin@zettamine.com";
          }
        }
        if (err.response.status == 423) {
          document.getElementById("attempts").innerHTML =
            "Account is Locked please contact admin@zettamine.com";
        }
        console.log(err);
      });
  }

  function validateEmail() {
    console.log(email);
    if (emailRegex.test(email)) {
      UserService.getUserByEmail(email)
        .then((res) => {
          setValidEmail(true);
        })
        .catch((error) => {
          console.log(error);
          document.getElementById("email-warning").innerHTML =
            "Email doesn't exists with our records";
          document.getElementById("email").focus();
          setValidEmail(false);
        });
    } else {
      document.getElementById("email-warning").innerHTML =
        "Email is not valid, Please provide valid email";
      document.getElementById("email").focus();
    }
  }

  return (
    <div className="">
      <section class=" pt-5">
        <div class="container-fluid h-custom">
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-5">
              <img
                src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                class="img-fluid"
                alt="Sample image"
              />
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
              <form>
                <h3>Login</h3>
                <span>
                  <br />
                  <br />
                  <p id="attempts" className="text-danger"></p>
                </span>
                <div data-mdb-input-init class="form-outline mb-4">
                  <label class="form-label" for="form3Example3">
                    Email address
                  </label>
                  <input
                    ref={emailRef}
                    pattern="^[a-zA-Z0-9!-.]+@(?:gmail|yahoo|zettamine)\\.(?:com|net|in)$"
                    autoFocus="autofocus"
                    type="email"
                    id="email"
                    class="form-control form-control-lg"
                    placeholder="Enter a valid email address"
                    onChange={() => {
                      email = emailRef.current.value;
                      document.getElementById("email-warning").innerHTML = "";
                    }}
                    onBlur={() => {
                      validateEmail();
                    }}
                  />
                  <span className="text-danger" id="email-warning"></span>
                </div>
                <label class="form-label" for="form3Example4">
                  Password
                </label>
                <div data-mdb-input-init class="form-outline mb-3">
                  <input
                    ref={passwordRef}
                    disabled={!validEmail}
                    type="password"
                    id="password"
                    class="form-control form-control-lg"
                    placeholder="Enter password"
                  />
                </div>

                <div class="d-flex justify-content-between align-items-center">
                  <div class="form-check mb-0">
                    <input
                      class="form-check-input me-2"
                      type="checkbox"
                      value=""
                      id="form2Example3"
                    />
                    <label class="form-check-label" for="form2Example3">
                      Remember me
                    </label>
                  </div>
                  <a href="#!" class="text-body">
                    Forgot password?
                  </a>
                </div>

                <div class="text-center text-lg-start mt-4 pt-2">
                  <button
                    type="button"
                    data-mdb-button-init
                    data-mdb-ripple-init
                    class="btn btn-primary btn-lg"
                    style={{ paddingLeft: "2.5rem", paddingRight: "2.5rem" }}
                    onClick={() => handleSubmit()}
                    disabled={!validEmail}
                  >
                    Login
                  </button>
                  <p class="small fw-bold mt-2 pt-1 mb-0">
                    Don't have an account?{" "}
                    <NavLink to="/register" className="link-danger">
                      Register
                    </NavLink>
                  </p>
                </div>
              </form>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
};

export default LoginForm;
