import './App.css';
import profile from "./image/profile.png";
import email from "./image/email.png";
import password from "./image/password.png";
function App() {
  return (
    <div className="main">
      <div className="sub-main">
        <div className="imgs">
          <div className="container-image">
            <img src={profile} alt="profile" className="profile"/>
          </div>
          
        </div>
        <div>
          <h1>Login</h1>
          <div>
            <img src={email} alt="email" className="email"/>
            <input type="text" placeholder="Enter email" className="name"/>
          </div>
          <div>
          <div className="second.input"></div>
            <img src={password} alt="password" className="email"/>
            <input type="password" placeholder="Enter password" className="name"/>
          </div>

          <div ClassName="login-button"></div>
          <button>Login</button>
        </div>
          <p className="link">
             <a href="#">New User?</a> or <a href="a">Sign Up</a>
          </p>
        
      </div>
    </div>
    
  );
}

export default App;
