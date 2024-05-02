import axios from "axios";

export class UserService {
  static baseUrl = "http://localhost:8181/user";
  static getUserByEmail(email) {
    let serverURL = this.baseUrl + "/fetch?email=" + email;
    return axios.get(serverURL);
  }
  static userLogin(username, password) {
    return axios.post(
      this.baseUrl + `/login?userName=${username}&password=${password}`
    );
  }
}
