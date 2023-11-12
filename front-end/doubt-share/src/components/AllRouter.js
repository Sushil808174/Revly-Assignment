import React from "react";
import { Route, Routes } from "react-router-dom";
import DoubtHistory from "./DoubtHistory";
import Login from "./Login";
import Register from "./Register";
import CreateDoubt from "./CreateDoubt";
import DoubtList from "./DoubtList";

const AllRouter = ()=>{

    return(
        
            <Routes>
                <Route path="/" element={<DoubtList/>}/>
                <Route path="/doubt-history" element={<DoubtHistory/>} />
                <Route path="/login" element={<Login/>} />
                <Route path="/register" element={<Register/>} />
                <Route path="/create-doubt" element={<CreateDoubt/>}/>
            </Routes>
       
    )
}

export default AllRouter;