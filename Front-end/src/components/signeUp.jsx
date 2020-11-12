import React, { useState } from "react";
import facade from "./apiFacade";

const SigneUp = () => {
  const [newUserCredentials, setNewUserCredentials] = useState({
    userName: "",
    password: "",
  });
  const performSignUp = (evt) => {
    evt.preventDefault();
    signUp(newUserCredentials.username, newUserCredentials.password);
  };
  const onChange = (evt) => {
    setNewUserCredentials({
      ...newUserCredentials,
      [evt.target.id]: evt.target.value,
    });
  };

  return (
    <>
      <form onChange={onChange}>
        <input type="text" placeholder="User Name" id="userName" />
        <input type="password" placeholder="Password" id="password" />
        <button onClick={performSignUp}>Login</button>
      </form>
    </>
  );
};

const signUp = (user, pass) => {
  facade.signUp(user, pass);
};

export default SigneUp;
