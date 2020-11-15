import React from "react";

const Table = ({ list }) => {
  return (
    <table class="table">
      <tr>
        <th>Username</th>
        <th>Zodiac Sign</th>
        <th>Favorit flower</th>
      </tr>
      {list.map((object) => {
        return (
          <tr key={object.username}>
            <td>{object.username}</td>
            <td>{object.zodiacsign}</td>
            <td>{object.flower}</td>
          </tr>
        );
      })}
    </table>
  );
};

export default Table;
