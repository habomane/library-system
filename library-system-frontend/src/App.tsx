import { useState } from 'react'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <h1 className='bg-red-50'>{count}</h1>
    </>
  )
}

export default App
