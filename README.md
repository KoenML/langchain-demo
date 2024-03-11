# Langchain Demo

The main demo is in document-loader-demo

## Local Model

To run the main demo with a local model, first make sure you have an Ollama Docker container running, with the appropriate model.

To do so, run ```docker run -d --gpus=all -v ollama:/root/.ollama -p 11434:11434 --name ollama ollama/ollama``` (remove the gpu flag if you don't have the nvidia toolbox installed) and then run ```docker exec -it ollama ollama pull $MODEL_NAME``` where ```$MODEL_NAME``` should be replaced with the Ollama model name of your choice.


Then adjust the main method of the document-loader-demo with the same model name and run it.

## OpenAI

To run with OpenAI API, get an OpenAI API-key and set it in your enviroment as $OPENAI_API_KEY

Adjust the main method of the module, changing ```OllamaModelService``` and ```OllamaEmbeddingService``` into ```OpenAiModelService``` and ```OpenAiEmbeddingService```. Then change the model name to an [Open AI Model](https://platform.openai.com/docs/models/overview) as well as uncommenting the embedding model declaration. Finally, use the EMBEDDING_MODEL constant to provision an OpenAI Embedding model from ```embeddings``` and run the main method.
