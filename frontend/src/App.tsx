import Chatbot from './components/Chatbot'
import './App.css'

function App() {
  return (
    <div className="App">
      <Chatbot apiUrl="http://localhost:8080/api/chat" />
    </div>
  )
}

export default App
