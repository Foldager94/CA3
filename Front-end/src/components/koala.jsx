import React, { useEffect, useState } from "react";
import { GetKoala } from "./../sites";
import facade from "./apiFacade";

const url = GetKoala;

const Koala = () => {
  const [koala, setKoala] = useState({ fact: "", link: "" });

  useEffect(() => {
    const option = facade.makeOptions("GET", true);
    fetch(url, option)
      .then((res) => res.json())
      .then((data) => {
        setKoala(data);
      });
  }, []);
  return (
    <>
      <img src={koala.link} alt="Koala" width="600" height="600" />
      <p>{koala.fact}</p>
    </>
  );
};

export default Koala;
