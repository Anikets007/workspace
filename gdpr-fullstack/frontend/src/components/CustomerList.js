import React, {useEffect, useState} from 'react';
import {fetchCustomers, requestDeletion} from '../services/api';

export default function CustomerList({token}) {
  const [customers,setCustomers]=useState([]);

  useEffect(()=>{
    fetchCustomers(token).then(data=>setCustomers(data || []));
  },[token]);

  async function handleDelete(id){
    await requestDeletion(id, token);
    // reload
    fetchCustomers(token).then(data=>setCustomers(data || []));
  }

  return (
    <div>
      <h2>Customers</h2>
      <table border="1" cellPadding="6">
        <thead><tr><th>ID</th><th>Name</th><th>Email</th><th>Actions</th></tr></thead>
        <tbody>
          {customers.map(c=>(
            <tr key={c.id}>
              <td>{c.id}</td>
              <td>{c.firstName} {c.lastName}</td>
              <td>{c.email}</td>
              <td>
                <button onClick={()=>handleDelete(c.id)}>Request Deletion</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
