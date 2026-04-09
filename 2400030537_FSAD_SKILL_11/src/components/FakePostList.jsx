import { useEffect, useState } from "react";
import axios from "axios";

export default function FakePostList() {
  const [posts, setPosts] = useState([]);
  const [userId, setUserId] = useState("");

  const loadPosts = () => {
    axios.get("https://dummyjson.com/posts")
      .then(res => setPosts(res.data.posts));
  };

  useEffect(() => {
    loadPosts();
  }, []);

  const filtered = userId
    ? posts.filter(p => p.userId == userId)
    : posts;

  return (
    <div>
      <h2>Posts</h2>

      <select onChange={(e) => setUserId(e.target.value)}>
        <option value="">All</option>
        <option value="1">User 1</option>
        <option value="2">User 2</option>
        <option value="3">User 3</option>
      </select>

      <button onClick={loadPosts}>Refresh</button>

      {filtered.map(p => (
        <div key={p.id}>
          <h4>{p.title}</h4>
          <p>{p.body}</p>
        </div>
      ))}
    </div>
  );
}