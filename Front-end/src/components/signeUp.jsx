import React, { useState } from "react";
import facade from "./apiFacade";

const SigneUp = () => {
  const [newUserCredentials, setNewUserCredentials] = useState({
    username: "",
    password: "",
    zodiacsign: "aries",
    flower: "Primula",
  });

  const zodiacOptions = [
    "aries",
    "taurus",
    "gemini",
    "cancer",
    "leo",
    "virgo",
    "libra",
    "scorpio",
    "sagittarius",
    "capricorn",
    "aquarius",
    "pisces",
  ];

  const flowerOptions = ["Primula", "Rose", "Tulip"];

  const performSignUp = (evt) => {
    evt.preventDefault();
    signUp(
      newUserCredentials.username,
      newUserCredentials.password,
      newUserCredentials.zodiacsign,
      newUserCredentials.flower
    );
    console.log(newUserCredentials);
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
        <input type="text" placeholder="User Name" id="username" />
        <br />
        <input type="password" placeholder="Password" id="password" />
        <br />
        <select id="zodiacsign">
          {zodiacOptions.map((sign) => {
            return <option>{sign}</option>;
          })}
        </select>
        <br />
        <select id="flower">
          {flowerOptions.map((flower) => {
            return <option>{flower}</option>;
          })}
        </select>
        <br />
        <button onClick={performSignUp}>Submit</button>
        <p>{JSON.stringify(newUserCredentials)}</p>
      </form>
    </>
  );
};

const signUp = (user, pass, zodiacsign, flower) => {
  facade.signUp(user, pass, zodiacsign, flower);
};

export default SigneUp;
