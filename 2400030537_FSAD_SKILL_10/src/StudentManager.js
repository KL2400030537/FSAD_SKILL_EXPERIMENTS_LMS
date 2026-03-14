import React, { useState } from "react";

function StudentManager() {

 const initialStudents = [
  {id:1,name:"Rahul",course:"B.Tech"},
  {id:2,name:"Priya",course:"BCA"},
  {id:3,name:"Arjun",course:"MCA"},
  {id:4,name:"Sneha",course:"MBA"},
  {id:5,name:"Kiran",course:"B.Sc"}
 ];

 const [students,setStudents] = useState(initialStudents);

 const [newStudent,setNewStudent] = useState({
  id:"",
  name:"",
  course:""
 });

 const handleChange = (e) => {
  setNewStudent({
   ...newStudent,
   [e.target.name]: e.target.value
  });
 };

 const addStudent = () => {

  setStudents([...students,newStudent]);

  setNewStudent({
   id:"",
   name:"",
   course:""
  });
 };

 const deleteStudent = (id) => {
  const updated = students.filter(student => student.id !== id);
  setStudents(updated);
 };

 return (

  <div style={{textAlign:"center"}}>

   <h2>Student Manager</h2>

   <input
    name="id"
    placeholder="ID"
    value={newStudent.id}
    onChange={handleChange}
   />

   <input
    name="name"
    placeholder="Name"
    value={newStudent.name}
    onChange={handleChange}
   />

   <input
    name="course"
    placeholder="Course"
    value={newStudent.course}
    onChange={handleChange}
   />

   <button onClick={addStudent}>Add Student</button>

   {students.length === 0 ? (
    <p>No students available</p>
   ) : (

   <table border="1" style={{margin:"20px auto"}}>

    <thead>
     <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Course</th>
      <th>Action</th>
     </tr>
    </thead>

    <tbody>

     {students.map(student => (

      <tr key={student.id}>
       <td>{student.id}</td>
       <td>{student.name}</td>
       <td>{student.course}</td>

       <td>
        <button onClick={()=>deleteStudent(student.id)}>
         Delete
        </button>
       </td>

      </tr>

     ))}

    </tbody>

   </table>

   )}

  </div>
 );
}

export default StudentManager;