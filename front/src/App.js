import React from 'react'
import CategoryForm from './category/CategoryForm'
import { StoreProvider } from './StoreProvider'
import CategoryList from './category/CategoryList'


function App() {
  return <StoreProvider>
    <CategoryForm />
    <hr />
    <CategoryList />
  </StoreProvider>;
}

export default App;
