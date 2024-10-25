import React, { useState } from 'react';
import { View, Text, TextInput, Button, Image, StyleSheet, Picker, TouchableOpacity } from 'react-native';
import * as ImagePicker from 'expo-image-picker';
import DateTimePicker from '@react-native-community/datetimepicker';

const AgendamentoColeta = () => {
  const [categoria, setCategoria] = useState('');
  const [subtipo, setSubtipo] = useState('');
  const [data, setData] = useState(new Date());
  const [local, setLocal] = useState('');
  const [showDatePicker, setShowDatePicker] = useState(false);
  const [image, setImage] = useState(null);

  // Função para abrir a câmera
  const openCamera = async () => {
    // Solicita permissão para usar a câmera
    const { status } = await ImagePicker.requestCameraPermissionsAsync();
    if (status === 'granted') {
      const result = await ImagePicker.launchCameraAsync({
        allowsEditing: true,
        aspect: [4, 3],
        quality: 1,
      });

      if (!result.cancelled) {
        setImage(result.uri);  // Salva a imagem capturada
      }
    } else {
      alert('Permissão para acessar a câmera é necessária.');
    }
  };

  const onChangeDate = (event, selectedDate) => {
    const currentDate = selectedDate || data;
    setShowDatePicker(false);
    setData(currentDate);
  };

  return (
    <View style={styles.container}>
      <Text>Agenda Coleta</Text>

      {/* Área de imagem com cantos arredondados */}
      <TouchableOpacity onPress={openCamera}>
        <View style={styles.imageContainer}>
          {image ? (
            <Image source={{ uri: image }} style={styles.image} />
          ) : (
            <Text style={styles.placeholderText}>Foto</Text>
          )}
        </View>
      </TouchableOpacity>

      <Picker
        selectedValue={categoria}
        style={styles.input}
        onValueChange={(itemValue) => setCategoria(itemValue)}
      >
        <Picker.Item label="Categoria de resíduo" value="" />
        <Picker.Item label="Seco" value="seco" />
        <Picker.Item label="Úmido" value="umido" />
        <Picker.Item label="Eletrônico" value="eletronico" />
      </Picker>

      <TextInput
        style={styles.input}
        placeholder="Subtipo: Papelão, Plástico"
        onChangeText={setSubtipo}
        value={subtipo}
      />

      <Button title="Data e Hora" onPress={() => setShowDatePicker(true)} />
      {showDatePicker && (
        <DateTimePicker
          value={data}
          mode="datetime"
          display="default"
          onChange={onChangeDate}
        />
      )}

      <TextInput
        style={styles.input}
        placeholder="Local da Coleta: Endereço"
        onChangeText={setLocal}
        value={local}
      />

      <Button title="Agendar" onPress={() => {
        // Enviar dados para o backend ou armazenar localmente
        console.log({ categoria, subtipo, data, local, image });
      }} />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    padding: 20,
    alignItems: 'center',  // Centraliza os itens horizontalmente
  },
  input: {
    borderWidth: 1,
    padding: 10,
    marginVertical: 5,
    borderRadius: 5,
    width: '100%', // Garante que os campos ocupem toda a largura disponível
  },
  imageContainer: {
    width: 150,
    height: 150,
    borderRadius: 75,
    borderWidth: 1,
    borderColor: '#ccc',
    justifyContent: 'center',
    alignItems: 'center',
    marginBottom: 20,
    overflow: 'hidden',
  },
  image: {
    width: '100%',
    height: '100%',
  },
  placeholderText: {
    color: '#aaa',
  },
});

export default AgendamentoColeta;
