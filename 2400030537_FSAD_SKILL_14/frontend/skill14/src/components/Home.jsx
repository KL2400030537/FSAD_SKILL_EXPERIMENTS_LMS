import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

function Home() {
  const navigate = useNavigate();

  useEffect(() => {
    const user = localStorage.getItem("username");
    if (!user) {
      navigate("/login");
    }
  }, []);

  return <h2>Welcome to Home</h2>;
}

export default Home;