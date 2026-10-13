import React, { useState } from 'react';
import './App.css';

function App() {
  const [searchTerm, setSearchTerm] = useState('');
  
  // Initial courses list
  const [courses, setCourses] = useState([
    { id: 1, title: 'Web Development', description: 'Learn HTML, CSS, JavaScript, React' },
    { id: 2, title: 'Python', description: 'Learn Python programming from scratch' },
    { id: 3, title: 'Java Programming', description: 'Learn Java core and object oriented design' }
  ]);

  // New course form states
  const [newTitle, setNewTitle] = useState('');
  const [newDescription, setNewDescription] = useState('');

  // Handle Add Course Form Submit
  const handleAddCourse = (e) => {
    e.preventDefault();
    if (!newTitle.trim() || !newDescription.trim()) {
      alert('Dayachesi andhuru details fill cheyandi!');
      return;
    }

    const newCourseObj = {
      id: courses.length + 1,
      title: newTitle,
      description: newDescription
    };

    setCourses([...courses, newCourseObj]); // List lo kotha course add chestunnam
    setNewTitle(''); // Input fields clear chestunnam
    setNewDescription('');
  };

  const filteredCourses = courses.filter(course =>
    course.title.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div className="container">
      {/* Hero Section */}
      <div className="hero">
        <h1>Welcome to Online Course Management</h1>
        <p>Learn new skills and build your future with our courses.</p>
        <button className="btn-explore">Explore Courses</button>
      </div>

      {/* Add Course Form Section */}
      <div className="add-course-section">
        <h2>Add New Course</h2>
        <form onSubmit={handleAddCourse} className="course-form">
          <input
            type="text"
            placeholder="Course Title"
            value={newTitle}
            onChange={(e) => setNewTitle(e.target.value)}
            className="form-input"
          />
          <input
            type="text"
            placeholder="Course Description"
            value={newDescription}
            onChange={(e) => setNewDescription(e.target.value)}
            className="form-input"
          />
          <button type="submit" className="btn-add">Add Course</button>
        </form>
      </div>

      {/* Available Courses Section */}
      <div className="courses-section">
        <h2>Available Courses</h2>
        
        {/* Search Bar */}
        <input
          type="text"
          placeholder="Search courses..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          className="search-input"
        />

        {/* Course Cards Grid */}
        <div className="course-grid">
          {filteredCourses.length > 0 ? (
  filteredCourses.map((course) => (
    <div key={course.id} className="course-card">
      <h3>{course.title}</h3>
      <p>{course.description}</p>

      <button
        type="button"
        onClick={() => {
          setCourses((prevCourses) =>
            prevCourses.filter((c) => c.id !== course.id)
          );
        }}
      >
        Delete
      </button>
    </div>
  ))
) : (
  <p>No courses found!</p>
)}
        </div>
      </div>
    </div>
  
  );
}

export default App;