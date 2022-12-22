# Streaming_1905_RAZAFINDRATANDRA_MIRADOMAHEFA_FITAHIANA

#Streaming Audio/Video/image

to run:
  javac -d . *.java
  java serveur.Serveur
  java client.Client
  
_le seurveur envoie une playlist au client
_le client fait son choix et renvoie son choix au serveur
_le serveur renvoie les choix du client byte/byte

  _Pour l'audio
      _le serveur envoie le fichier byte/byte 
      _le client le lit byte/byte
  _Pour la video
      _le serveur envoie les bytes dans une fichier temporaire
      _creation d'une thread pour stocker les premiers bytes sinon le client ne verra rien
      _lancement de la lecture du fichier temporaire
  _pour l'image 
      _envoie immediat
      _lecture immediat
