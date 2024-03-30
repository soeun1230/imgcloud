import React, {useEffect, useState} from 'react';

function App() {
  const [hello, setHello] = useState('')

      useEffect(() => {
          fetch('/api/json')
          .then(response => {
          if(!response.ok){
            throw new Error('ERROR');
          }
          return response.json();
          })
          .then(data => {
            setHello(data.hello);
          })
          .catch(error => console.log(error))
      }, []);

      return (
          <div>
              백엔드에서 가져온 데이터입니다 : {hello}
          </div>
      );
}

export default App;
