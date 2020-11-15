import React, { useState } from "react";
import facade from "./apiFacade";
import { GetAllUsers } from "./../sites";
import Table from "./table";

const url = GetAllUsers;

const AdminSite = () => {
  const [users, setCount] = useState([]);
  console.log(users);
  return (
    <>
      <button
        onClick={() =>
          fetch(url, facade.makeOptions("GET", true))
            .then((res) => res.json())
            .then((data) => setCount(data))
        }
      >
        Hente antal bruger
      </button>
      <Table list={users} />
    </>
  );
};

export default AdminSite;
