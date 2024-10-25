App.js
import React from 'react';
import { View, Text, Image} from 'react-native';

function App(){
  return(
    <View>
      <View style={{justifyContent: 'center', alignItems: 'center'}}>
      <Text style={{marginTop: 80}}>Meu Perfil</Text>
        <Image
            source={{ uri: 'https://avatars.githubusercontent.com/u/1713290?v=4' }}
            style={{width: 120, height: 120, marginTop: 30, borderRadius: 80 }}
        />
      </View>

      <View style={{marginLeft: 5}}>
        <Text style={{color: 'blue', marginTop: 15}}>Dados pessoais:</Text>
        <Text>AUDRIN PEREIRA, 53 anos, DEVELOPER</Text>

        <Text style={{color: 'blue', marginTop: 15}}>Formação:</Text>
        <Text>SISTEMAS PARA INTERNET - FATEC</Text>
        <Text>ARTE PUBLICITARIA - ESCOLA PANAMERICANA DE ARTES</Text>

        <Text style={{color: 'blue', marginTop: 15}}>Experiência:</Text>
        <Text>ABDL</Text>
        <Text>SENAC</Text>
        <Text>RÁDIO 95 FM</Text>

        <Text style={{color: 'blue', marginTop: 15}}>Projetos:</Text>
        <Text>PEGLEV</Text>
        <Text>EDUCADORES DO MEIO AMBIENTE</Text>
      </View>
    </View>
  )
}

export default App;