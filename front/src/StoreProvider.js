import React, { createContext, useReducer } from 'react';
import Reducer from './Reducer.js'


const initialState = {
    category: { list: [] },
    todo: { list: [], item: {} },
    error: ""
}

const Store = createContext(initialState);

export const StoreProvider = ({ children }) => {

    const [state, dispatch] = useReducer(Reducer, initialState);

    return <Store.Provider value = {{ state, dispatch }} className="centered">
        {children}
    </Store.Provider>

}

export default Store;

