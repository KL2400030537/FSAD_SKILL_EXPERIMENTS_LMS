import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Login() {
  const [data, setData] = useState({ username: "", password: "" });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setData({ ...data, [e.target.name]: e.target.value });
  };

  const handleLogin = async () => {
    const res = await axios.post("http://localhost:8080/api/auth/login", data);

    localStorage.setItem("username", res.data.username);
    navigate("/home");
  };

  const goToRegister = () => {
    navigate("/register");
  };

  return (
    <div>
      <h2>Login</h2>
      <input name="username" onChange={handleChange} />
      <input name="password" type="password" onChange={handleChange} />
      <button onClick={handleLogin}>Login</button>
      <button onClick={goToRegister}>New user? Register</button>
    </div>
  );
}

export default Login;