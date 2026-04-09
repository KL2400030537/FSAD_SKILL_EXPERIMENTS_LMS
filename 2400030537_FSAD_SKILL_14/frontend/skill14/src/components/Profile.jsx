import { useEffect, useState } from "react";
import axios from "axios";

function Profile() {
  const [user, setUser] = useState({});
  

  useEffect(() => {
    const username = localStorage.getItem("username");

    if (!username) {
      window.location.href = "/login";
      return;
    }

    axios
      .get(`http://localhost:8080/api/auth/profile/${username}`)
      .then((res) => setUser(res.data));
  }, []);

  return (
    <div>
      <h2>Profile</h2>
      <p>ID: {user.id}</p>
      <p>Username: {user.username}</p>
      <p>Email: {user.email}</p>
    </div>
  );
}

export default Profile;