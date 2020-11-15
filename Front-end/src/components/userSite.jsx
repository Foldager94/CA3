import React, { useState, useEffect } from "react";
import facade from "./apiFacade";
import { GetUserFlower } from "./../sites";
import Koala from "./koala";

const url = GetUserFlower;

const UserSite = () => {
  const [flower, setFlower] = useState({});
  const username = facade.getUserName();

  useEffect(() => {
    const options = facade.makeOptions("GET", true);
    fetch(url + username, options)
      .then((res) => res.json())
      .then((data) => {
        setFlower(data);
      });
  }, []);

  return (
    <>
      <p>Favorit Flower: {flower.flowerName}</p>
      <Koala />
    </>
  );
};

export default UserSite;
