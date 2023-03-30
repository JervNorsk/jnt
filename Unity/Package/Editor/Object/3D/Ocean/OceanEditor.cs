using System.Collections;
using System.Collections.Generic;
using UnityEditor;
using UnityEditor.SearchService;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.WSA;

namespace JervNorsk.Tool.Object3D
{
    [CustomEditor(typeof(Ocean))]
    public class OceanEditor : Editor
    {
        public override void OnInspectorGUI()
        {
            DrawDefaultInspector();

            var rawTarget = target as Ocean;

            if (GUILayout.Button("Generate"))
            {
                rawTarget.Reset();
                rawTarget.FixedUpdate();
            }
        }

        internal class Menu
        {

            [MenuItem("GameObject/3D Object/Ocean")]
            private static void CreateGameObject()
            {
                Ocean.CreateGameObject();
            }
        }
    }
}